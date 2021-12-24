package com.kmm.playground.appcomponents

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}