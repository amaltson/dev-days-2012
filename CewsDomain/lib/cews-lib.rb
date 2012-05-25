require 'java'
java_require 'cews-lib'

class JavaIntegrationTest
  java_signature 'void sayHello()'
  def sayHello
    puts 'Hello, World!'
  end
end
