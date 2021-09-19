# OLPlatform with Java EE implementation

## Program model

APIs:

- GET       /api/programs
- POST      /api/programs
- PUT       /api/programs
- DELETE    /api/programs/{id}

Example: create a Program.

```json
// POST /api/programs
{
  "name": "P1",
  "description": "test creating program P1",
  "startDate": "2021-09-18 14:30:00 GMT-4:00",
  "endDate": "2022-01-07 12:30:00 GMT-4:00"
}
```

Result:

```json
{
  "id": 1,
  "name": "P1",
  "description": "test creating program P1",
  "startDate": "2021-09-18 14:30:00 -0400",
  "endDate": "2022-01-07 11:30:00 -0500"
}
```

Example: update a Program

```json
// PUT /api/programs
{
  "id": "1",
  "name": "P1",
  "description": "test updating program P1",
  "startDate": "2021-09-18 14:30:00 GMT-4:00",
  "endDate": "2022-01-07 12:30:00 GMT-4:00"
}
```

## Instructor model

APIs:

- GET     /api/instructors
- POST    /api/instructors
- PUT     /api/instructors
- DELETE  /api/instructors/{id}

Example: create a Instructor.

```json
// POST /api/instructors
{
  "firstName": "Evan",
  "lastName": "Lauerson",
  "username": "elauerson",
  "password": "abc",
  "email": "elauerson@fanshaweonline.ca",
  "phoneNumber": "(519)1112222",
  "salary": "89000",
  "sin": "901 092 163"
}
```

Example: update a Instructor.

```json
// PUT /api/instructors
{
  "id": "1",
  "firstName": "Evan",
  "lastName": "Lauerson",
  "username": "elauerson",
  "password": "abc",
  "email": "elauerson@fanshaweonline.ca",
  "phoneNumber": "(519)1113344",
  "salary": "89000",
  "sin": "263 810 483"
}
```

## Student model

APIs:

- GET     /api/students
- POST    /api/students
- PUT     /api/students
- DELETE  /api/students/{id}

Example: create a Student.

```json
// POST /api/students
{
  "firstName": "Hai",
  "lastName": "Nguyen",
  "username": "h_nguyen89212",
  "password": "abc",
  "email": "h_nguyen89212@fanshaweonline.ca",
  "phoneNumber": "(519)5038196"
}
```

Example: update a Student

```json
{
  "id": "2",
  "firstName": "Hai",
  "lastName": "Nguyen",
  "username": "h_nguyen89212",
  "password": "def",
  "email": "h_nguyen89212@fanshaweonline.ca",
  "phoneNumber": "(519)5038196"
}
```
