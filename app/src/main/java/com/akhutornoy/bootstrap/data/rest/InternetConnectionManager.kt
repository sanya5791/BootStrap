package com.akhutornoy.bootstrap.data.rest

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import com.akhutornoy.bootstrap.data.rest.InternetConnectionManager.InternetState.*


class InternetConnectionManager(
    context: Context,
    networkRequest: NetworkRequest
) {
    private val connMgr: ConnectivityManager?

    init {
        connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        connMgr?.requestNetwork(networkRequest, ConnectivityStateCallback())
    }

    var state: InternetState = AVAILABLE

    fun isConnected() = state == AVAILABLE

    private inner class ConnectivityStateCallback: ConnectivityManager.NetworkCallback() {
        override fun onLost(network: Network?) {
            super.onLost(network)
            state = LOST
        }

        override fun onUnavailable() {
            super.onUnavailable()
            state = UNAVAILABLE
        }

        override fun onLosing(network: Network?, maxMsToLive: Int) {
            super.onLosing(network, maxMsToLive)
            state = LOSING
        }

        override fun onAvailable(network: Network?) {
            super.onAvailable(network)
            state = AVAILABLE
        }
    }

    enum class InternetState {
        AVAILABLE, LOST, LOSING, UNAVAILABLE
    }

}