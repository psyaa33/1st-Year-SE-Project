# **Labs Week 3** 

Create an activity diagram and sequence diagram:
- [Activity Diagram](../assets/Week_3/activityDiagram.png)
- [Sequence Diagram](../assets/Week_3/sequenceDiagram.png)
## Activity Diagram
We used a Activity Diagram to represent the module selection and approval of the basic requirements of the module selection process. This diagram shows a deatailed plan for the process of a student module application. It flows through all the requirements the university demands and checks with the correct actors to assure the student is allowed to take the course they desire

The diagram has 4 swimlines displaying all the actors involved in this process. This helps to clearly show which actor is involved in each step of the diagram. 


[Link for tutorial on Activity Diagram](https://creately.com/guides/activity-diagram-tutorial/)


### Reasoning for the Diagram
We felt the activity diagram was more appriate the diagram clearly displays all the necessary requirements that need to be approved by the Server in order for the student's requests to be accepted. Plus, the diagram shows when other actors, like the head of teaching and module convener, need to be involved to help with the approval process.

It was more suitable than the sequence diagram as the activity diagram involves decision nodes which are crucial in checking the requirements.
### Important Questions
|Question|
:--
|From producing this diagram we had to make the assumption that if the student chooses incorrect options then it should fail. We need to ask the customer if the following assumption is in fact correct.|

## Sequence Diagram
This markdown focuses on the design of the Approval Workflow Management aspect of a new software system that the university wants to have for handling module options and allowing students to sign up for optional modules, including those from other departments. The system aims to streamline the process of module selection, credit management, and obtaining necessary approvals from various stakeholders in the university such as module convenors and the Head of Teaching.
### Reasoning for the Diagram
The Approval Workflow Management process involves multiple steps, decisions, and interactions between students, system components, and staff (module convenors and the Head of Teaching). A Sequence Diagram is chosen to illustrate this process because it effectively represents the sequence of interactions over time between all the actors and the participants. This type of diagram is particularly suited to showing how different system entities communicate amongst each other, the order of operations, and the conditions under which these interactions occur, which are essential for understanding and implementing the approval workflow within the software.

Unlike other types of UML diagrams, such as Activity Diagrams which are better for showing the flow of control or decisions within a process. 
### Important Questions
|Questions|
:--
|Based on the diagram, we may need clarification on specific business rules such as criteria for automatic vs manual approval or replies and how exceptions are managed within the workflow.|
|How the system interacts with external systems like Bluecastle and Timetabling can pinpoint integration challenges or requirements|
