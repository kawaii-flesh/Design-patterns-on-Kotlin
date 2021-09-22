enum class Importance
{
    Low,
    Medium,
    High
}

class Event(val importance: Importance)

abstract class Interceptor(var nextInterceptor: Interceptor?)
{
   
    abstract fun processingEvent(event: Event)
}

class LowInterceptor(nextInterceptor: Interceptor? = null): Interceptor(nextInterceptor)
{
    override fun processingEvent(event: Event)
    {
        if(event.importance == Importance.Low)
            // Do something
        else
            nextInterceptor?.processingEvent(event)
    }
}

class MediumInterceptor(nextInterceptor: Interceptor? = null): Interceptor(nextInterceptor)
{
    override fun processingEvent(event: Event)
    {
        if(event.importance == Importance.Medium)
            // Do something
        else
            nextInterceptor?.processingEvent(event)
    }
}

class HighInterceptor(nextInterceptor: Interceptor? = null): Interceptor(nextInterceptor)
{
    override fun processingEvent(event: Event)
    {
        if(event.importance == Importance.High)
            // Do something
        else
            nextInterceptor?.processingEvent(event)
    }
}

fun main()
{
    val highInterceptor = HighInterceptor()
    val mediumInterceptor = MediumInterceptor(highInterceptor)
    val lowInterceptor = LowInterceptor(mediumInterceptor)
    
    val event = Event(Importance.High)
    lowInterceptor.processingEvent(event)
}