abstract class State(val executer: Executer)
{
    abstract fun workIt()
    abstract fun makeIt()
    abstract fun doIt()
}

enum class StateType
{
    HARDER,
    BETTER,
    FASTER,
    STRONGER
}

class Harder(executer: Executer): State(executer)
{
    override fun workIt(){}
    override fun makeIt(){}
    override fun doIt(){}
}

class Better(executer: Executer): State(executer)
{
    override fun workIt(){}
    override fun makeIt()
    {
        // Can change state
        if((0..10).random() == 5)
            executer.stateType = StateType.FASTER
    }
    override fun doIt(){}
}

class Faster(executer: Executer): State(executer)
{
    override fun workIt(){}
    override fun makeIt(){}
    override fun doIt(){}
}

class Stronger(executer: Executer): State(executer)
{
    override fun workIt(){}
    override fun makeIt(){}
    override fun doIt(){}
}

class Executer(stateType: StateType)
{
    private lateinit var state: State
    var stateType: StateType = stateType
    set(value)
    {
        field = value
        state = when(value)
        {
            StateType.BETTER -> Better(this)
            StateType.FASTER -> Faster(this)
            StateType.HARDER -> Harder(this)
            StateType.STRONGER -> Stronger(this)
        }
    }
    fun doComplexThing()
    {
        state.workIt()
        state.makeIt()
        state.doIt()
        stateType = listOf(StateType.BETTER, StateType.FASTER, StateType.HARDER, StateType.STRONGER).random()
    }
}

fun main()
{
    val executer = Executer(StateType.BETTER)
    executer.doComplexThing()
}