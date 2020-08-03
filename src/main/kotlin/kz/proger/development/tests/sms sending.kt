package kz.proger.development.tests

fun main() {
    try {
        throwError()
    } catch (ex: Exception) {
        sendErrorSms(ex.message!!)
    }
}

fun sendErrorSms(errorText: String) {
    throw RuntimeException("couldn't send sms")
}

fun throwError() {
    throw IllegalStateException("Coda couldn't do something")
}
