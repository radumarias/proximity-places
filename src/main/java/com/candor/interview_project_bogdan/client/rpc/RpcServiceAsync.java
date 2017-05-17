package com.candor.interview_project_bogdan.client.rpc;

import com.google.gwt.core.client.GWT;

/**
 * 
 * @author bp
 *
 */
public interface RpcServiceAsync {

	/**
	 * Utility class to get the RPC Async interface from client-side code
	 */
	public static final class Util {
		private static RpcServiceAsync instance;

		public static final RpcServiceAsync getInstance() {
			if (instance == null) {
				instance = (RpcServiceAsync) GWT.create(RpcService.class);
			}
			return instance;
		}

		private Util() {
			// Utility class should not be instantiated
		}
	}
}
