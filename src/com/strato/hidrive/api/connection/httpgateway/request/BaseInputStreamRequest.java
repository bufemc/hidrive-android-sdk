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
package com.strato.hidrive.api.connection.httpgateway.request;

import java.io.InputStream;
import java.util.List;

import com.strato.hidrive.api.connection.httpgateway.interfaces.HttpRequestParamsVisitor;
import com.strato.hidrive.api.connection.httpgateway.visitors.HttpGetRequestParamsVisitor;

public abstract class BaseInputStreamRequest extends Request {
	
	private InputStream inputStream;
	private long streamLength;

	public BaseInputStreamRequest(Method method) {
		super(method);
	}

	public BaseInputStreamRequest(String methodName) {
		super(methodName);
	}

	public BaseInputStreamRequest(String methodName, List<BaseParam<?>> params) {
		super(methodName, params);
	}

	public BaseInputStreamRequest(String methodName, BaseParam<?>... params) {
		super(methodName, params);
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream, long streamLength) {
		this.inputStream = inputStream;
		this.streamLength = streamLength;
	}

	public long getStreamLength() {
		return streamLength;
	}

	@Override
	protected HttpRequestParamsVisitor<?> createVisitor() {
		return new HttpGetRequestParamsVisitor();
	}

}
