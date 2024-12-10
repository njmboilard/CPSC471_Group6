import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/projects';

// Project CRUD operations for a project
export const listProjects = () => axios.get(REST_API_BASE_URL);

export const createProject = (project) => axios.post(REST_API_BASE_URL, project);

export const getProject = (projectId) => axios.get(REST_API_BASE_URL + '/' + projectId);

export const updateProject = (projectId, project) => axios.put(REST_API_BASE_URL + '/' + projectId, project);

export const deleteProject = (projectId) => axios.delete(REST_API_BASE_URL + '/' + projectId);

// Project Manager CRUD operations for a specific project
export const listProjectManager = (projectId) => axios.get(`${REST_API_BASE_URL}/${projectId}/projectManagers`);

export const createProjectManager = (projectId, projectManager) =>	axios.post(`${REST_API_BASE_URL}/${projectId}/projectManagers`, projectManager);

export const getProjectManager = (projectId, employeeId) =>	axios.get(`${REST_API_BASE_URL}/${projectId}/projectManagers/${employeeId}`);

export const updateProjectManager = (projectId, employeeId, projectManager) =>	axios.put(`${REST_API_BASE_URL}/${projectId}/projectManagers/${employeeId}`, projectManager);

export const deleteProjectManager = (projectId, employeeId) =>	axios.delete(`${REST_API_BASE_URL}/${projectId}/projectManagers/${employeeId}`);

// Contract Designer CRUD operations for a specific project
export const listContractDesigner = (projectId) => axios.get(`${REST_API_BASE_URL}/${projectId}/contractDesigners`);

export const createContractDesigner = (projectId, contractDesigner) =>	axios.post(`${REST_API_BASE_URL}/${projectId}/contractDesigners`, contractDesigner);

export const getContractDesigner = (projectId, contractorId) =>	axios.get(`${REST_API_BASE_URL}/${projectId}/contractDesigners/${contractorId}`);

export const updateContractDesigner = (projectId, contractorId, contractDesigner) =>	axios.put(`${REST_API_BASE_URL}/${projectId}/contractDesigners/${contractorId}`, contractDesigner);

export const deleteContractDesigner = (projectId, employeeId) =>	axios.delete(`${REST_API_BASE_URL}/${projectId}/contractDesigners/${employeeId}`);

// Field Staff CRUD operations for a specific project
export const listInHouseDesigner = (projectId) => axios.get(`${REST_API_BASE_URL}/${projectId}/inHouseDesigners`);

export const createInHouseDesigner = (projectId, inHouseDesigner) =>	axios.post(`${REST_API_BASE_URL}/${projectId}/inHouseDesigners`, inHouseDesigner);

export const getInHouseDesigner = (projectId, employeeId) =>	axios.get(`${REST_API_BASE_URL}/${projectId}/inHouseDesigners/${employeeId}`);

export const updateInHouseDesigner = (projectId, employeeId, inHouseDesigner) =>	axios.put(`${REST_API_BASE_URL}/${projectId}/inHouseDesigners/${employeeId}`, inHouseDesigner);

export const deleteInHouseDesigner = (projectId, employeeId) =>	axios.delete(`${REST_API_BASE_URL}/${projectId}/inHouseDesigners/${employeeId}`);

// Document Controller CRUD operations for a specific project
export const listFieldStaff = (projectId) => axios.get(`${REST_API_BASE_URL}/${projectId}/fieldStaff`);

export const createFieldStaff = (projectId, fieldStaff) =>	axios.post(`${REST_API_BASE_URL}/${projectId}/fieldStaff`, fieldStaff);

export const getFieldStaff = (projectId, employeeId) =>	axios.get(`${REST_API_BASE_URL}/${projectId}/fieldStaff/${employeeId}`);

export const updateFieldStaff = (projectId, employeeId, fieldStaff) =>	axios.put(`${REST_API_BASE_URL}/${projectId}/fieldStaff/${employeeId}`, fieldStaff);

export const deleteFieldStaff = (projectId, employeeId) =>	axios.delete(`${REST_API_BASE_URL}/${projectId}/fieldStaff/${employeeId}`);

// Issue CRUD operations for a specific project
export const listIssues = (projectId) => axios.get(`${REST_API_BASE_URL}/${projectId}/issues`);

export const createIssues = (projectId, issue) => axios.post(`${REST_API_BASE_URL}/${projectId}/issues`, issue);

export const getIssues = (projectId, issueId) => axios.get(`${REST_API_BASE_URL}/${projectId}/issues/${issueId}`);

export const updateIssues = (projectId, issueId, issue) => axios.put(`${REST_API_BASE_URL}/${projectId}/issues/${issueId}`, issue);

export const deleteIssues = (projectId, issueId) => axios.delete(`${REST_API_BASE_URL}/${projectId}/issues/${issueId}`);

// Assigned Plan CRUD operations for a specific project
export const listAssignedPlans = (projectId) => axios.get(`${REST_API_BASE_URL}/${projectId}/assignedPlans`);

export const createAssignedPlan = (projectId, assignedPlan) =>	axios.post(`${REST_API_BASE_URL}/${projectId}/assignedPlans/${drawingNumber}`, assignedPlan);

export const getAssignedPlan = (projectId, drawingNumber) =>	axios.get(`${REST_API_BASE_URL}/${projectId}/assignedPlans/${drawingNumber}`);

export const updateAssignedPlan = (projectId, drawingNumber, assignedPlan) =>	axios.put(`${REST_API_BASE_URL}/${projectId}/assignedPlans/${drawingNumber}`, assignedPlan);

export const deleteAssignedPlan = (projectId, drawingNumber) =>	axios.delete(`${REST_API_BASE_URL}/${projectId}/assignedPlans/${drawingNumber}`);