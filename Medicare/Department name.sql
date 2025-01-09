-- Step 1: Create the table
CREATE TABLE departments (
    department_id SERIAL PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    department_head VARCHAR(100) NOT NULL,
    department_area VARCHAR(100) NOT NULL,
    department_employment INTEGER NOT NULL,
    department_phone_no VARCHAR(15) NOT NULL,
    department_opening_time TIME NOT NULL,
    department_closing_time TIME NOT NULL
);

-- Step 2: Insert data into the table
INSERT INTO departments (
    department_name, department_head, department_area, department_employment, department_phone_no, department_opening_time, department_closing_time
) VALUES
    ('Department of Pediatrics', 'Dr. Smith', 'Maharashtra', 20, '1234567890', '09:00:00', '17:00:00'),
    ('Department of Cardiology', 'Dr. Johnson', 'Delhi', 15, '0987654321', '08:00:00', '16:00:00'),
    ('Department of Orthopedics', 'Dr. Anderson', 'Tamil Nadu', 12, '5678901234', '10:00:00', '18:00:00'),
    ('Department of Gynecology', 'Dr. Williams', 'Kolkata', 18, '3456789012', '09:30:00', '17:30:00'),
    ('Department of Neurology', 'Dr. Brown', 'Hyderabad', 10, '9876543210', '08:30:00', '16:30:00'),
    ('Department of Ophthalmology', 'Dr. Taylor', 'Pune', 14, '2345678901', '10:30:00', '18:30:00'),
    ('Department of Dermatology', 'Dr. Martinez', 'Ahmedabad', 16, '8765432109', '09:00:00', '17:00:00'),
    ('Department of ENT', 'Dr. Garcia', 'Jaipur', 11, '5432109876', '08:00:00', '16:00:00'),
    ('Department of Psychiatry', 'Dr. Rodriguez', 'Lucknow', 13, '4321098765', '11:00:00', '19:00:00'),
    ('Department of Dental', 'Dr. Lopez', 'Kochi', 17, '2109876543', '09:30:00', '17:30:00');