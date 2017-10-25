# Authentication Server

The idea is that the use can login either through 
a local account or a social account.
This will return a token that the user can then use with 
the public APIs, since they are sessionless.

The token should be short-lived and contain the roles
the use has.