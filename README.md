Solution Lab — Design Patterns
Overview
This repository contains solutions to two tasks implemented using design patterns. The focus is on applying design patterns in real-world scenarios to demonstrate how they can help structure code more effectively and solve complex coordination and behavioral problems.


Task 1: Series (Using the Strategy Pattern)
This task focuses on managing episodes of a TV show using the Strategy design pattern. The goal is to create a flexible system that allows sorting and displaying episodes in different orders (e.g., normal order, reverse, or random) and simulating a binge-watching experience.


Task 2: Airport Tower Simulator (Using the Mediator Pattern)
The second task involves simulating an airport's control tower using the Mediator pattern. The Control Tower coordinates communication between various types of aircraft (passenger planes, cargo planes, helicopters) to manage takeoffs, landings, and emergency situations efficiently.


Task 1: Series — Strategy Pattern
Purpose:
The objective of this task is to simulate managing episodes of a TV series, providing various ways to sort and display episodes. The Strategy pattern is used to manage different sorting behaviors for episodes.

Key Classes:
Main:

Purpose: The entry point of the program. It runs the simulation of the episodes by using different strategies to display the episodes in different orders (normal, reverse, random). It also initiates the binge-watching feature by displaying all episodes without any specific order.

Methods:

main(String[] args): Executes the simulation with different strategies and displays the result.

Series:

Purpose: Represents an individual episode of a series. Each episode has a unique identifier (season and episode number) and a duration.

Methods:

getEpisodeInfo(): Returns information about the episode, such as its ID and duration.

setDuration(int duration): Sets the duration for the episode.

Season:

Purpose: Represents a collection of episodes. It holds a list of Series objects (episodes) and provides methods for sorting and displaying them in different orders.

Methods:

addEpisode(Series episode): Adds an episode to the season.

sortEpisodes(Strategy strategy): Sorts the episodes based on the provided strategy (e.g., normal order, reverse, or random).

displayEpisodes(): Displays the episodes in the current order.

Strategy Interface:

Purpose: Defines the sorting strategy for episodes. Different strategies (normal, reverse, random) implement this interface to provide flexible sorting behavior.

Methods:

sort(List<Series> episodes): A method for sorting episodes based on the specific strategy.

Concrete Strategy Classes:

Purpose: These classes implement the Strategy interface to provide different sorting mechanisms.

Classes:

NormalOrderStrategy: Sorts episodes in the normal order.

ReverseOrderStrategy: Sorts episodes in reverse order.

RandomOrderStrategy: Sorts episodes randomly (using a seed to ensure reproducibility).

Output Example:
The program allows the user to see episodes sorted in normal order, reverse order, or randomly. It also provides a binge-watching experience where episodes are shown without any order.

  ![image](https://github.com/user-attachments/assets/7d713ac4-f713-4240-b3e6-4fcf91e9e0dc)


Task 2: Airport Tower Simulator — Mediator Pattern
Purpose:
This task demonstrates the Mediator pattern by simulating an airport control tower. The ControlTower acts as a mediator, managing communication between different types of aircraft (passenger planes, cargo planes, helicopters) and ensuring that they take off, land, or taxi in an orderly manner. Emergency situations are handled by prioritizing certain aircraft (e.g., MAYDAY calls).

Key Classes:
Aircraft:

Purpose: This is an abstract class representing a general aircraft. It defines the basic structure for all aircraft types, including an identifier and a method for receiving messages.

Methods:

send(String msg, TowerMediator m): Sends a message (request for takeoff or landing) to the tower.

receive(String msg): Receives a message from the control tower.

PassengerPlane, CargoPlane, Helicopter:

Purpose: These classes represent specific types of aircraft. They extend the Aircraft class and provide specific implementations of the receive method to handle messages differently based on the aircraft type.

Methods:

receive(String msg): Each type of aircraft reacts to messages differently. For example, a passenger plane may respond to a landing request with a confirmation, while a helicopter might react with a different message.

TowerMediator:

Purpose: This is an interface that defines the contract for the mediator. It includes methods for broadcasting messages between aircraft and granting runway access.

Methods:

broadcast(String msg, Aircraft sender): Sends a message to all aircraft, except the sender.

requestRunway(Aircraft a): Requests the runway for an aircraft and returns whether the request is approved (based on queues and priorities).

ControlTower:

Purpose: This is the concrete implementation of the TowerMediator. It maintains two queues (one for takeoffs and one for landings) and manages runway access. It handles normal requests and emergencies (e.g., prioritizing aircraft in distress).

Methods:

broadcast(String msg, Aircraft sender): Implements the broadcasting of messages between aircraft.

requestRunway(Aircraft a): Checks if an aircraft can land or take off, prioritizing emergency aircraft (e.g., MAYDAY calls).

handleEmergency(Aircraft emergency): Handles emergency requests by clearing the runway and notifying other aircraft.

SimulationDriver:

Purpose: This class simulates the airport environment. It generates random aircraft, assigns them fuel levels, and schedules requests for takeoff or landing every second. It demonstrates the interaction between aircraft and the control tower in real-time.

Methods:

runSimulation(): Starts the simulation, generating aircraft, sending requests, and showing tower decisions in real-time.

createRandomAircraft(): Creates an aircraft with random fuel levels and randomly assigns it a type (passenger, cargo, or helicopter).

Example Output:
The simulation shows the status of aircraft as they request takeoff, landing, or emergency landings, with the tower managing the communication and prioritizing emergency situations.

![image](https://github.com/user-attachments/assets/1c9ce929-f772-422e-b2b7-9253dc96ab8e)




