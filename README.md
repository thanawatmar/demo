# Api specification

## [Get] /salary

params
- timestamp ***(Range filter)***
- employer ***(String filter)***
- location ***(String filter)***
- jobTitle ***(String filter)***
- yearAtEmployer ***(Range filter)***
- yearOfExperience ***(Range filter)***
- salary ***(Range filter)***
- singingBonus ***(Range filter)***
- annualBonus ***(Range filter)***
- annualStockValueBonus ***(Range filter)***
- gender ***(String filter)***
- additionalComments ***(String filter)***
- fields ***(target fields separate by ',')***

Range filter
- greaterThan
- lessThan
- greaterThanOrEqual
- lessThanOrEqual
- equals
- notEquals
- in
- notIn

String filter
- contains
- doesNotContain
- equals
- notEquals
- in
- notIn

example curl
```
curl --location 'http://localhost:8080/salary?fields=employer%2Ctimestamp%2Cgender&salary.greaterThan=200000&sort=employer%2Cdesc&pages=5&size=5'
```
