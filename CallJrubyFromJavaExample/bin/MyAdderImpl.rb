require 'java'

java_package 'myruby'

class MyAdderImpl
  include Java::MyAdder
  java_signature 'int add(int, int)'
  def add(a, b)
    a + b
  end
end