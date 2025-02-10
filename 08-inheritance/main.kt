// to have ability to inherit we need to use 'open' keyword
open class BasicInfoProvider {
    open fun providerInfo() { // We need add 'open' keyword 
        println("provider info")
    }
}

// inheritance
class FancyInfoProvider : BasicInfoProvider() {
    override fun providerInfo() {
        println("fancy provider info")
    }
}

fun main() {
    val provider = BasicInfoProvider()
    val fancyProvider = FancyInfoProvider()
    provider.providerInfo()
    fancyProvider.providerInfo()
}