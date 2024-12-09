import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCListIssue = () => {

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
                { id: 1, description: 'death and destruction', status: 'idk', projectId: 1, employeeId: 'PIT0040'},
                { id: 2, description: 'vast swarms of bees', status: 'hmm', projectId: 1, employeeId: 'PIT0040'},
                { id: 3, description: 'aggressive geese', status: 'maybe', projectId: 1, employeeId: 'PIT0040'},
              ];
            const dummyProjectName = "Dummy Project";


            setIssues(dummyIssues);
            setProjectName(dummyProjectName);
        }
    }, [projectId]);

    function back() {
        navigator(`/documentcontrol/projects`);
    }

    function addNewIssue() {
		navigator(`/documentcontrol/projects/${projectId}/issues/add`);
	}

	function updateIssue(issueId) {
		navigator(`/documentcontrol/projects/${projectId}/issues/update/${issueId}`);
	}

	function removeIssue(issueId) {
		console.log(issueId);

		// remove issue logic here
	}

    return (
        <div className='container'><br />
            <h2>{projectName} Issues</h2>
            <button className="btn btn-dark mb-2" onClick={addNewIssue}>Add Issue</button>
            <button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Issue ID</th>
                        <th>Issue Description</th>
                        <th>Issue Status</th>
                        <th>Project ID</th>
                        <th>Employee ID</th>
                        <th>Actions</th>
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
                                <td>
                                    <button className="btn btn-dark" onClick={() => updateIssue(issue.id)}>Update</button>
								    <button
								    	className="btn btn-dark"
								    	onClick={() => {
								    		if (window.confirm("Are you sure you want to delete issue " + issue.id + "?")) {
								    			removeIssue(issue.id);
								    		}
								    	}}
								    	style={{marginLeft: '10px'}}
								    >
								    	Delete
								    </button>
							    </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
};

export default DCListIssue;