# OLPlatform with Java EE implementation

## Program model

APIs:

- GET     /api/programs
- POST    /api/programs
- PUT     /api/programs

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
