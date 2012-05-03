package myruby;

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.javasupport.util.RuntimeHelpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;


public class MyAdderImpl extends RubyObject  {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("require 'java'\n" +
            "\n" +
            "java_package 'myruby'\n" +
            "\n" +
            "class MyAdderImpl\n" +
            "  include Java::MyAdder\n" +
            "  java_signature 'int add(int, int)'\n" +
            "  def add(a, b)\n" +
            "    a + b\n" +
            "  end\n" +
            "end").toString();
        __ruby__.executeScript(source, "MyAdderImpl.rb");
        RubyClass metaclass = __ruby__.getClass("MyAdderImpl");
        metaclass.setRubyStaticAllocator(MyAdderImpl.class);
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: MyAdderImpl");
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private MyAdderImpl(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * A static method used by JRuby for allocating instances of this object
     * from Ruby. Generally not for user comsumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public static IRubyObject __allocate__(Ruby ruby, RubyClass metaClass) {
        return new MyAdderImpl(ruby, metaClass);
    }
        
    /**
     * Default constructor. Invokes this(Ruby, RubyClass) with the classloader-static
     * Ruby and RubyClass instances assocated with this class, and then invokes the
     * no-argument 'initialize' method in Ruby.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public MyAdderImpl() {
        this(__ruby__, __metaclass__);
        RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "initialize");
    }

    
    public int add(int a, int b) {
        IRubyObject ruby_a = JavaUtil.convertJavaToRuby(__ruby__, a);
        IRubyObject ruby_b = JavaUtil.convertJavaToRuby(__ruby__, b);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "add", ruby_a, ruby_b);
        return (Integer)ruby_result.toJava(int.class);

    }

}
