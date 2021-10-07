#Subject :

Write a simple fizz-buzz REST server.
The original fizz-buzz consists in writing all numbers from 1 to 100, and just replacing all multiples of 3 by "fizz", all multiples of 5 by "buzz", and all multiples of 15 by "fizzbuzz". The output would look like this: "1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16,...".

Your goal is to implement a web server that will expose a REST API endpoint that:
Accepts five parameters : three integers int1, int2 and limit, and two strings str1 and str2.
Returns a list of strings with numbers from 1 to limit, where: all multiples of int1 are replaced by str1, all multiples of int2 are replaced by str2, all multiples of int1 and int2 are replaced by str1str2.

The server needs to be:
Ready for production
Easy to maintain by other developers

- Add a statistics endpoint allowing users to know what the most frequent request has been.
  This endpoint should:
- Accept no parameter
- Return the parameters corresponding to the most used request, as well as the number of hits for this request

Don’t forget to add unit tests.

Please commit your project on Git and send me the url.


# My comment 

Because we still have some use case that was not clear, 
I decided to add those following: 
- int1 and int2 must not be equal and none of them can be lower than 0
- str1 and str2 must not be empty (in order to keep the output string cool)

I also decided to add a parameter into the uri during stats because from my point of view, with only one endpoint, there is no need to check the same value.
I decided not to use database for this exercise
I add a configuration for a docker 
I add a docker for development configuration
I add a config for prometheus 
I add also a configuration to be manage by an elk stack

And finally, I choose and hexagonal architecture and kotlin as language. 

