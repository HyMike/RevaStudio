
export type TicketStatus = "OPEN" | "IN_PROGRESS" | "CLOSED";

export interface TicketResponse {
    ticketId: number; 
    subject: string;
    body: string;
    createdAt: string;
    status: TicketStatus;
    customerId: number | null; 
    employeeId: number | null;
}
