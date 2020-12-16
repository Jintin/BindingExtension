@file:Suppress("UNCHECKED_CAST")

package com.jintin.bindingextension

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

internal fun <V : ViewBinding> getBinding(obj: Any, layoutInflater: LayoutInflater): V {
    val clazz = (obj.javaClass
        .genericSuperclass as ParameterizedType)
        .actualTypeArguments[0] as (Class<*>)
    try {
        return clazz.getMethod(
            "inflate",
            LayoutInflater::class.java
        ).invoke(null, layoutInflater) as V
    } catch (ex: Exception) {
        throw RuntimeException("The ViewBinding inflate function has been changed.", ex)
    }
}

internal fun <V : ViewBinding> BindingActivity<V>.getBinding(): V {
    return getBinding(this, layoutInflater)
}

internal fun <V : ViewBinding> BindingFragment<V>.getBinding(): V {
    return getBinding(this, layoutInflater)
}