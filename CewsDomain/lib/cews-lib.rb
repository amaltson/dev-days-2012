require 'java'
java_require 'cews-lib'
java_package 'com.otpp'

class JavaIntegrationTest
  java_signature 'void sayHello()'
  def sayHello
    puts 'Hello, World!'
  end
end
