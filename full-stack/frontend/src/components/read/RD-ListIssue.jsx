import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const RDListIssue = () => {

    const [issues, setIssues] = useState([]);
    const {id : projectId} = useParams();
    const [projectName, setProjectName] = useState('');

    const navigator = useNavigate();

    useEffect(() => {
        if (projectId) {
            // Insert Fetch issues


            // Insert Fetch project name


            // test data to be deleted after
            const dummyIssues = [
                { id: 1, description: 'Shoddy Materials', status: 'Open', projectId: 1, employeeId: '13'},
                { id: 2, description: 'Rusty Rails', status: 'Open', projectId: 1, employeeId: '13'},
                { id: 3, description: 'Electrical Errors', status: 'Open', projectId: 1, employeeId: '24'},
              ];
            const dummyProjectName = "Project";


            setIssues(dummyIssues);
            setProjectName(dummyProjectName);
        }
    }, [projectId]);

    function back() {
        navigator(`/reader/projects`);
    }

    return (
        <div className='container'><br />
            <h2>{projectName} Issues</h2>
            <button className="btn btn-dark mb-2" onClick={back}>Back</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Issue ID</th>
                        <th>Issue Description</th>
                        <th>Issue Status</th>
                        <th>Project ID</th>
                        <th>Employee ID</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        issues.map(issue =>
                            <tr key={issue.id}>
                                <td>{issue.id}</td>
                                <td>{issue.description}</td>
                                <td>{issue.status}</td>
                                <td>{issue.projectId}</td>
                                <td>{issue.employeeId}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
};

export default RDListIssue;