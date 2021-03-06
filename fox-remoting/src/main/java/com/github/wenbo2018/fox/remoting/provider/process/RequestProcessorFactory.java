package com.github.wenbo2018.fox.remoting.provider.process;

import com.github.wenbo2018.fox.common.extension.ExtensionServiceLoader;
import com.github.wenbo2018.fox.remoting.invoker.process.ThreadPoolResponseProcessor;
import com.github.wenbo2018.fox.remoting.invoker.process.ResponseProcessor;

/**
 * Created by shenwenbo on 2016/9/28.
 */
public class RequestProcessorFactory {

    public static RequestProcessor selectProcessor() {
        RequestProcessor requestProcessor = ExtensionServiceLoader.getExtension(RequestProcessor.class);
        if (requestProcessor != null) {
            return requestProcessor;
        } else {
            return new ThreadPoolRequestProcessor();
        }
    }

    public static ResponseProcessor selectResponseProcessor() {
        ResponseProcessor responseProcessor = ExtensionServiceLoader.getExtension(ResponseProcessor.class);
        if (responseProcessor != null) {
            return responseProcessor;
        } else {
            return new ThreadPoolResponseProcessor();
        }
    }

}
