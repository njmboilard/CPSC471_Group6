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