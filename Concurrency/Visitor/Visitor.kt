interface IVisitor
{
    fun visitButton(){}
    fun visitCheckBox(){}
}

class ButtonVisitor: IVisitor
{
    override fun visitButton()
    {
        // Do something
    }
}

class CheckBoxVisitor: IVisitor
{
    override fun visitCheckBox()
    {
        // Do something
    }
}

abstract class UIElement
{
    abstract fun draw()
    abstract fun accept(visitor: IVisitor)
}

class Button: UIElement()
{
    override fun draw(){}
    override fun accept(visitor: IVisitor)
    {
        if(visitor is ButtonVisitor)
            visitor.visitButton()
    }
}

class CheckBox: UIElement()
{
    override fun draw(){}
    override fun accept(visitor: IVisitor)
    {
        if(visitor is CheckBoxVisitor)
            visitor.visitCheckBox()
    }
}

fun main()
{
    val button = Button()
    val buttonVisitor = ButtonVisitor()

    button.accept(buttonVisitor)
}