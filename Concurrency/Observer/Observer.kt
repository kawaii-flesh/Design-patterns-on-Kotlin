enum class EventType
{
    SH_EXECUTED,
    STATE_CHANGED
}

interface IListener
{
    fun update(event: EventType)
}

class StateListener: IListener
{
    override fun update(event: EventType)
    {
        if(event == EventType.STATE_CHANGED)
        {   
            // Do something
        }
    }
}

class SHListener: IListener
{
    override fun update(event: EventType)
    {
        if(event == EventType.SH_EXECUTED)
        {   
            // Do something
        }
    }
}

class Notifier
{
    private val listeners = mutableMapOf<EventType, IListener>()
    var state = false
    private set

    fun addListener(event: EventType, listener: IListener){listeners[event] = listener}
    fun removeListener(event: EventType, listener: IListener) = listeners.remove(event, listener)

    fun invertState(){state = !state; notify(EventType.STATE_CHANGED)}
    fun sh()
    {
        // Do something
        notify(EventType.SH_EXECUTED)
    }

    private fun notify(event: EventType) = listeners.forEach{if(it.key == event) it.value.update(event)}
}

fun main()
{
    val notifier = Notifier()
    
    val stateListener = StateListener()
    val shListener = SHListener()

    notifier.addListener(EventType.STATE_CHANGED, stateListener)
    notifier.addListener(EventType.SH_EXECUTED, shListener)

    notifier.invertState()
    notifier.sh()
}