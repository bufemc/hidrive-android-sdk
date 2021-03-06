/**
* Copyright 2014 STRATO AG
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* 
* http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.strato.hidrive.api.bll.share;

import java.util.ArrayList;
import java.util.List;

import com.strato.hidrive.api.connection.gateway.SingleResultGateway;
import com.strato.hidrive.api.connection.httpgateway.request.BaseParam;
import com.strato.hidrive.api.connection.httpgateway.request.LongParam;
import com.strato.hidrive.api.connection.httpgateway.request.Param;
import com.strato.hidrive.api.connection.httpgateway.request.PutRequest;
import com.strato.hidrive.api.connection.httpgateway.request.Request;
import com.strato.hidrive.api.dal.ShareLinkEntity;
import com.strato.hidrive.api.interfaces.DataReader;

public class EditShareGateway extends SingleResultGateway<ShareLinkEntity> {
	private String linkId;
	private long timeToLive;
	private String linkPassword;

	public EditShareGateway(String linkId, long timeToLive, String linkPassword) {
		super();

		this.linkId = linkId;
		this.timeToLive = timeToLive;
		this.linkPassword = linkPassword;
	}

	@Override
	protected ShareLinkEntity prepareObject(DataReader datareader) {
		return new ShareLinkEntity(datareader);
	}

	@Override
	protected Request prepareRequest() {
		List<BaseParam<?>> params = new ArrayList<BaseParam<?>>();
		params.add(new Param("id", this.linkId));
		params.add(new LongParam("ttl", this.timeToLive));

		if (this.linkPassword != null) {
			params.add(new Param("password", linkPassword));
		}
		

		return new PutRequest("share", params);
	}
}
