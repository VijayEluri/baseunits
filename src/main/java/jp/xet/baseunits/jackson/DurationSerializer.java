/*
 * Copyright 2011 Daisuke Miyamoto. (http://d.hatena.ne.jp/daisuke-m)
 * Created on 2013/08/20
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package jp.xet.baseunits.jackson;

import java.io.IOException;

import jp.xet.baseunits.time.Duration;
import jp.xet.baseunits.time.TimeUnit;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.SerializerBase;

/**
 * TODO for daisuke
 */
public class DurationSerializer extends SerializerBase<Duration> {
	
	/**
	 * インスタンスを生成する。
	 */
	public DurationSerializer() {
		super(Duration.class);
	}
	
	@Override
	public void serialize(Duration value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		long longValue = (value == null) ? 0 : value.to(TimeUnit.millisecond);
		jgen.writeNumber(longValue);
	}
}