import React, { useEffect, useState } from 'react';
import { getDashboard } from '../services/api';

const DashboardPage = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    const loadData = async () => {
      try {
        const token = localStorage.getItem('token');
        const res = await getDashboard(token);
        setData(res.data);
      } catch (err) {
        alert('Error fetching data');
      }
    };
    loadData();
  }, []);

  return (
    <div>
      <h2>Saved API Responses</h2>
      {data.map((item, index) => (
        <div key={index}>
          <p><strong>URL:</strong> {item.url}</p>
          <pre>{item.responseBody}</pre>
          <hr />
        </div>
      ))}
    </div>
  );
};

export default DashboardPage;