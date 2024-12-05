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
                { number: 1, description: 'death and destruction', status: 'idk', projectId: 1, employeeId: 'PIT0040'},
                { number: 2, description: 'vast swarms of bees', status: 'hmm', projectId: 1, employeeId: 'PIT0040'},
                { number: 3, description: 'aggressive geese', status: 'maybe', projectId: 1, employeeId: 'PIT0040'},
              ];
            const dummyProjectName = "Dummy Project";


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
                        <th>Issue Number</th>
                        <th>Issue Description</th>
                        <th>Issue Status</th>
                        <th>Project ID</th>
                        <th>Employee ID</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        issues.map(issue =>
                            <tr key={issue.number}>
                                <td>{issue.number}</td>
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