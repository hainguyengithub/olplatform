INSERT INTO
  academic_advisor (
    email,
    first_name,
    last_name,
    password,
    phone_number,
    username
  )
VALUES
  (
    'fwallis@fanshawec.ca',
    'Faith',
    'Wallis',
    'abc',
    '519-452-4430 x4915',
    'fwallis'
  ),
  (
    'asutherland@fanshawec.ca',
    'Ashleigh',
    'Sutherland',
    'abc',
    '519-452-4430 x2031',
    'asutherland'
  ),
  (
    'bantone-collar@fanshawec.ca',
    'Bev',
    'Antone-Collar',
    'abc',
    '519-452-4176',
    'bantone-collar'
  );

INSERT INTO
  instructor (
    email,
    first_name,
    last_name,
    password,
    phone_number,
    salary,
    sin,
    username
  )
VALUES
  (
    'elauersen@fanshaweonline.ca',
    'Evan',
    'Lauersen',
    'abc',
    '418-555-0107',
    '89500',
    '542 519 103',
    'elauersen'
  ),
  (
    's_sharpe6133@fanshaweonline.ca',
    'Steve',
    'Sharpe',
    'abc',
    '902-555-0171',
    '67900',
    '754 386 423',
    's_sharpe6133'
  ),
  (
    'o_ali@fanshaweonline.ca ',
    'Osam',
    'Ali',
    'abc',
    '709-555-0135',
    '100400',
    '526 415 476',
    'o_ali'
  );

INSERT INTO
  program (
    name,
    description,
    start_date,
    end_date,
    academic_advisor_id
  )
VALUES
  (
    'Computer Programmer Analyst 2',
    'There is no career more valued, in-demand or dynamic these days than an IT career. If you have a passion for coding and computers, and you’re ready to develop the skills to land your dream job as a computer programmer, Fanshawe’s Computer Programming and Analysis advanced diploma is the right fit for you.',
    '2021-09-07 00:00:00.000000',
    '2022-01-11 00:00:00.000000',
    '1'
  ),
  (
    'Addictions and Mental Health',
    'The Addictions and Mental Health one-year program will be beneficial for seasoned practitioners who are committed to maintaining currency, and/or who are seeking career advancement.',
    '2021-09-07 00:00:00.000000',
    '2022-01-11 00:00:00.000000',
    '2'
  ),
  (
    '911 and Public Safety Communications',
    'This hands-on and comprehensive program provides students with the foundational knowledge and specialized communication skills required to work in the highly demanding and unpredictable field of public safety communications.',
    '2022-09-07 00:00:00.000000',
    '2023-01-11 00:00:00.000000',
    '3'
  );

INSERT INTO
  course (code, name, description, start_date, end_date)
VALUES
  (
    'BSCI-6031',
    'Fundamentals of Addictions',
    "This course will introduce students to substance-related and behavioural addictions as indicated in the Diagnostic and Statistical Manual. Through the biopsychosocial and trauma informed lens, students will critically analyze different theories of addiction and current initiatives in field addiction services. The signs and symptoms of dependence, abuse, problematic, and occasional patterns of substance use will be addressed. Throughout the course, students will engage in self- reflection regarding their understanding of addictions with the aim to challenge one's own beliefs and assumptions.",
    '2021-09-07 00:00:00.000000',
    '2022-01-11 00:00:00.000000'
  ),
  (
    'TELE-1025',
    'Call Processing & Procedure-Intro',
    "In this course students will learn to process calls for Police, Fire and EMS, recording incident details and reports while applying effective interview and interrogation techniques as well as triage and call categorization protocols. Confirmation of locations through computer-integrated and paper mapping while maintaining a client-centered approach with a diverse caller base for both emergent and non-emergent situations will be emphasized. Students will have hands on experience with current public safety communications technologies, including Hexagon Intergraph® Computer-Aided Dispatch. At the end of this course, students will be prepared for the level two labs (TELE3014, TELE3015, TELE3016).",
    '2022-09-07 00:00:00.000000',
    '2023-01-11 00:00:00.000000'
  ),
  (
    'INFO-1215',
    'Database Fundamentals',
    'An introduction to relational database system design and development, by creating a variety of simple databases, based upon typical business requirements. Students build complete database solutions incorporating multi-table relational databases, forms, reports, queries, and test data. Students will also be introduced to the Structured Query Language.',
    '2021-09-07 00:00:00.000000',
    '2022-01-11 00:00:00.000000'
  );

INSERT INTO
  classroom (course_id, instructor_id, program_id)
VALUES
  ('1', '1', '2'),
  ('2', '3', '3'),
  ('3', '2', '1');

INSERT INTO
  student (
    email,
    first_name,
    last_name,
    password,
    phone_number,
    username
  )
VALUES
  (
    'h_nguyen89212@fanshaweonline.ca',
    'Hai',
    'Nguyen',
    'abc',
    '226-503-8196',
    'h_nguyen89212'
  ),
  (
    'g_moussa@fanshaweonline.ca',
    'George',
    'Moussa',
    'abc',
    '867-988-1037',
    'g_moussa'
  ),
  (
    'e_somers@fanshaweonline.ca',
    'Evan',
    'Somers',
    'abc',
    '403-302-3211',
    'e_somers'
  );

INSERT INTO
  seat (classroom_id, student_id)
VALUES
  ('3', '1'),
  ('2', '3'),
  ('1', '2');
