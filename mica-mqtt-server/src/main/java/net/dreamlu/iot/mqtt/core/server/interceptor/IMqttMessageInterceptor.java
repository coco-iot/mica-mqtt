/*
 * Copyright (c) 2019-2029, Dreamlu 卢春梦 (596392912@qq.com & dreamlu.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dreamlu.iot.mqtt.core.server.interceptor;

import net.dreamlu.iot.mqtt.codec.MqttMessage;
import org.tio.core.ChannelContext;

/**
 * mqtt 消息拦截器
 *
 * @author L.cm
 */
public interface IMqttMessageInterceptor {

	/**
	 * 建链后触发本方法，注：建链不一定成功，需要关注参数isConnected
	 *
	 * @param context     ChannelContext
	 * @param isConnected 是否连接成功,true:表示连接成功，false:表示连接失败
	 * @param isReconnect 是否是重连, true: 表示这是重新连接，false: 表示这是第一次连接
	 * @throws Exception Exception
	 */
	default void onAfterConnected(ChannelContext context, boolean isConnected, boolean isReconnect) throws Exception {

	}

	/**
	 * 接收到TCP层传过来的数据后
	 *
	 * @param context       ChannelContext
	 * @param receivedBytes 本次接收了多少字节
	 * @throws Exception Exception
	 */
	default void onAfterReceivedBytes(ChannelContext context, int receivedBytes) throws Exception {

	}

	/**
	 * 解码成功后触发本方法
	 *
	 * @param context    ChannelContext
	 * @param message    MqttMessage
	 * @param packetSize packetSize
	 * @throws Exception Exception
	 */
	default void onAfterDecoded(ChannelContext context, MqttMessage message, int packetSize) throws Exception {

	}

	/**
	 * 处理一个消息包后
	 *
	 * @param context ChannelContext
	 * @param message MqttMessage
	 * @param cost    本次处理消息耗时，单位：毫秒
	 * @throws Exception Exception
	 */
	default void onAfterHandled(ChannelContext context, MqttMessage message, long cost) throws Exception {

	}

	/**
	 * 处理一个消息包后
	 *
	 * @param context       ChannelContext
	 * @param message       MqttMessage
	 * @param isSentSuccess 是否发送成功
	 * @throws Exception Exception
	 */
	default void onAfterSent(ChannelContext context, MqttMessage message, boolean isSentSuccess) throws Exception {

	}
}
