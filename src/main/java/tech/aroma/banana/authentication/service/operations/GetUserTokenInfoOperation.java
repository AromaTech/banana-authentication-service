/*
 * Copyright 2015 Aroma Tech.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 
package tech.aroma.banana.authentication.service.operations;


import javax.inject.Inject;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.aroma.banana.authentication.service.AuthenticationAssertions;
import tech.aroma.banana.authentication.service.data.TokenRepository;
import tech.aroma.banana.thrift.authentication.service.GetUserTokenInfoRequest;
import tech.aroma.banana.thrift.authentication.service.GetUserTokenInfoResponse;
import tech.sirwellington.alchemy.annotations.access.Internal;
import tech.sirwellington.alchemy.thrift.operations.ThriftOperation;

import static tech.sirwellington.alchemy.arguments.Arguments.checkThat;
import static tech.sirwellington.alchemy.arguments.assertions.Assertions.notNull;
import static tech.sirwellington.alchemy.generator.AlchemyGenerator.one;
import static tech.sirwellington.alchemy.generator.ObjectGenerators.pojos;

/**
 *
 * @author SirWellington
 */
@Internal
final class GetUserTokenInfoOperation implements ThriftOperation<GetUserTokenInfoRequest, GetUserTokenInfoResponse>
{
    private final static Logger LOG = LoggerFactory.getLogger(GetUserTokenInfoOperation.class);
    
    private final TokenRepository tokenRepository;

    @Inject
    GetUserTokenInfoOperation(TokenRepository tokenRepository)
    {
        checkThat(tokenRepository).is(notNull());
        
        this.tokenRepository = tokenRepository;
    }

    @Override
    public GetUserTokenInfoResponse process(GetUserTokenInfoRequest request) throws TException
    {
        AuthenticationAssertions.checkRequestNotNull(request);
        
        LOG.debug("Received request to get token info: {}", request);
        
        GetUserTokenInfoResponse response = one(pojos(GetUserTokenInfoResponse.class));
        
        return response;
    }

    @Override
    public String toString()
    {
        return "GetUserTokenInfoOperation{" + "tokenRepository=" + tokenRepository + '}';
    }

    
    
}
