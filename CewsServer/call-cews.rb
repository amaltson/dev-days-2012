Bundler.require
require 'java'

java_import 'java.net.URL'
java_import 'javax.xml.namespace.QName'
java_import 'com.otpp.ws.careerevent.CareerEvent'

url = URL.new('http://wasdev0/CareerEventWS/CareerEvent?wsdl')
qname = QName.new('http://careerevent.ws.otpp.com/', 'CareerEvent')

careerEventClient = CareerEvent.new(url, qname)
careerEvent = careerEventClient.getCareerEventWebService

puts "#{careerEvent.getVersion}"
