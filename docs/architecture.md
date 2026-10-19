# IntentTrace — System Architecture

## 1. Project Overview

IntentTrace is a runtime security system for AI agents.
It analyzes agent activity and proposed tool calls to detect
prompt injection and prevent unauthorized actions.

## 2. Core Components

### Target Agent
- Built using Python and an existing LLM.
- Reads documents and processes user tasks.
- Requests tools when necessary.

### Backend and Security Gateway
- Built using Java and Spring Boot.
- Receives agent tool-call requests.
- Coordinates security checks.
- Enforces allow, review, and block decisions.

### Security Analysis Engine
- Built using Python and FastAPI.
- Analyzes prompt injection, user intent, information sources,
  execution history, and proposed actions.
- Returns security findings to the backend.

### Database
- PostgreSQL.
- Stores execution traces, security decisions, and incidents.

### Frontend
- React.
- Displays agent activity, detected threats, risk assessments,
  and security decisions.

## 3. Request Flow

1. The user submits a task.
2. The target agent processes the task.
3. The agent reads external content when required.
4. The agent requests a tool action.
5. The backend intercepts the request.
6. The security engine analyzes the request and relevant history.
7. The backend applies its security policy.
8. The tool executes only if the action is authorized.
9. The decision and relevant events are stored.
10. The dashboard displays the result.

## 4. Security Boundary

The target agent must not directly execute protected tools.
All protected tool calls must pass through the backend gateway.

## 5. Initial Scope

The first prototype will support:
- Document summarization.
- Mock database search.
- A simulated email tool.
- Prompt-injection detection.
- Intent and action analysis.
- Risk assessment and tool-call authorization.
- Security event logging and visualization.

## 6. Technology Stack

- Java and Spring Boot
- Python and FastAPI
- Python-based target agent with an existing LLM
- React
- PostgreSQL
- Git and GitHub
- Docker and Docker Compose