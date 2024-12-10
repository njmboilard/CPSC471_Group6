import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/regions';

// Region CRUD operations for a region
export const listRegions = () => axios.get(REST_API_BASE_URL);

export const createRegion = (region) => axios.post(REST_API_BASE_URL, region);

export const getRegion = (regionId) => axios.get(REST_API_BASE_URL + '/' + regionId);

export const updateRegion = (regionId, region) => axios.put(REST_API_BASE_URL + '/' + regionId, region);

export const deleteRegion = (regionId) => axios.delete(REST_API_BASE_URL + '/' + regionId);



// Subdivision CRUD operations for a specific region
export const listSubdivisions = (regionId) => axios.get(`${REST_API_BASE_URL}/${regionId}/subdivisions`);

export const createSubdivision = (regionId, subdivision) =>	axios.post(`${REST_API_BASE_URL}/${regionId}/subdivisions`, subdivision);

export const getSubdivision = (regionId, chopCode) =>	axios.get(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}`);

export const updateSubdivision = (regionId, chopCode, subdivision) =>	axios.put(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}`, subdivision);

export const deleteSubdivision = (regionId, chopCode) =>	axios.delete(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}`);



// Location CRUD operations for a specific subdivision
export const listLocations = (regionId, chopCode) => axios.get(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations`);

export const createLocation = (regionId, chopCode, location) => axios.post(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations`, location);

export const getLocation = (regionId, chopCode, mileage) => axios.get(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}`);

export const updateLocation = (regionId, chopCode, mileage, location) => axios.put(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}`, location);

export const deleteLocation = (regionId, chopCode, mileage) => axios.delete(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}`);



// Plan CRUD operations for a specific plan

export const listPlans = (regionId, chopCode, mileage) => axios.get(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans`);

export const createPlan = (regionId, chopCode, mileage, plan) =>	axios.post(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans`, plan);

export const createArchivePlan = (regionId, chopCode, mileage, drawingNumber, archivePlan) => axios.post(	`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans/${drawingNumber}/archive`, archivePlan);

export const getPlan = (regionId, chopCode, mileage, drawingNumber) =>	axios.get(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans/${drawingNumber}`);

export const getArchivePlan = (regionId, chopCode, mileage, drawingNumber) => axios.get(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans/${drawingNumber}/archive`);

export const updatePlan = (regionId, chopCode, mileage, drawingNumber, plan) =>	axios.put(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans/${drawingNumber}`, plan);

export const updateArchivePlan = (regionId, chopCode, mileage, drawingNumber, archivePlan) => axios.put(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans/${drawingNumber}/archive`, archivePlan);

export const deletePlan = (regionId, chopCode, mileage, drawingNumber) =>	axios.delete(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans/${drawingNumber}`);

export const deleteArchivePlan = (regionId, chopCode, mileage, drawingNumber) => axios.delete(`${REST_API_BASE_URL}/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans/${drawingNumber}/archive`);