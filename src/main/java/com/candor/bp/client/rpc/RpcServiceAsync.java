package com.candor.bp.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RpcServiceAsync
{

    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static RpcServiceAsync instance;

        public static final RpcServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (RpcServiceAsync) GWT.create( RpcService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
