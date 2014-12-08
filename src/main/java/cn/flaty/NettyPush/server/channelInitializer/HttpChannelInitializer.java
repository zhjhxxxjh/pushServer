package cn.flaty.NettyPush.server.channelInitializer;

import cn.flaty.NettyPush.server.inHandler.HttpDemoHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

public class HttpChannelInitializer extends  AbstractChannelInitializer{
	
	private static String HTTPDECODER = "httpDecoder";
	private static String HTTPENCODER = "httpEncoder";

	@Override
	protected void initPipeline(ChannelPipeline pipeline) {
      this.addBaseChannel(pipeline);
     
      this.addCustomChannel(pipeline);
	}
	
	private void addCustomChannel(ChannelPipeline pipeline) {
		pipeline.addLast(new HttpDemoHandler());
		
	}

	private void addBaseChannel(ChannelPipeline pipeline){
		  pipeline.addFirst(HTTPDECODER, new HttpRequestDecoder());
	      pipeline.addFirst(HTTPENCODER, new HttpResponseEncoder());
	}

}
