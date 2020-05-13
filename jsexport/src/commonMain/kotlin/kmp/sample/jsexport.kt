package kmp.sample

import kotlin.js.JsName
import kotlin.js.JsExport

val highOrderFunction = { msg: String -> "highOrderFunction: $msg"}

@JsExport
@JsName("topLvlFunction")
fun topLvlFunction(msg: String) = "topLvlFunction: $msg"

enum class EnumSample { VAL1, VAL2 }

interface InterfaceSample {
    @JsName("interfaceMethod")
    fun interfaceMethod(enumSample: EnumSample) : String
}

interface CallbackSample {
    @JsName("call")
    fun call(input: EnumSample) : String
}

data class DataClassSample(val num: Int, val msg: String, val list: List<String>)

class ClassSample() : InterfaceSample {
    override fun interfaceMethod(enumSample: EnumSample) = "interfaceMethod: ${enumSample.name}"

    @JsName("methodWithCallBack")
    fun methodWithCallBack(callbackSample: CallbackSample) = "callbackSample: ${callbackSample.call(EnumSample.VAL2)}"

    @JsName("createDataClassSample")
    fun createDataClassSample(list: List<String>) = DataClassSample(1, "createDataClassSample", list)
}