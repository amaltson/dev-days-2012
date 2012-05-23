# dev-days-2012

Developer Days 2012 JRuby workshop

## Getting Started with the JRuby Projects
To use the JRuby projects you first need to understand some Rubyisms

### Bundler

The JRuby projects are using the [Bundler](http://gembundler.com/) a
standard dependency resolution tool for Ruby. Bundler is used in
conjunction with [jbundler](https://github.com/mkristian/jbundler) (a
bundler plugin?) to resolve Maven dependencies.

Therefore, to start using the JRuby you need to use `bundle`. For
example:

    $ cd CewsDomain
    bundle install
    bundle exec test/call_cews_jar.rb

Will install all the gem and jar dependencies and execute the tests in
the bundler context.

### Rake

Rake is the standard Ruby build tool and it will be used in the JRuby
projects. As mentioned above, you need to run everything in the Bundler
context, so executing a Rake task looks as follows (assuming you've run
`bundle install`:

    $ cd CewsDomain
    bundle exec rake test
