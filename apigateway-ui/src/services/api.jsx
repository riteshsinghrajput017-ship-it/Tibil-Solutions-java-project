import axios from 'axios';

const API_BASE = 'http://localhost:8088/api';

export const register = (userData) =>
  axios.post(`${API_BASE}/auth/register`, userData);

export const login = (userData) =>
  axios.post(`${API_BASE}/auth/login`, userData);

export const submitUrl = (url, token) =>
  axios.post(`${API_BASE}/apis`, { url }, {
    headers: { Authorization: `Bearer ${token}` }
  });

export const getDashboard = (token) =>
  axios.get(`${API_BASE}/apis`, {
    headers: { Authorization: `Bearer ${token}` }
  });