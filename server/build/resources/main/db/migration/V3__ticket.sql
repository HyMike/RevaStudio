CREATE TABLE ticket (
    ticket_id SERIAL PRIMARY KEY,
    subject VARCHAR(255) NOT NULL,
    body TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    customer_id INT REFERENCES customer(customer_id),
    employee_id INT REFERENCES employee(employee_id)
);


CREATE TABLE ticket_thread (
    ticket_thread_id SERIAL PRIMARY KEY, 
    ticket_id INT NOT NULL REFERENCES ticket(ticket_id) ON DELETE CASCADE,
    thread TEXT NOT NULL,
    created_at TIMESTAMP
);