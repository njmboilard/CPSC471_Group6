import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCIssue = () => {
	const [issueDescription, setIssueDescription] = useState('')
	const [issueStatus, setIssueStatus] = useState('')
    const [employeeId, setEmployeeId] = useState('')
	const {id : projectId, issueid : issueId} = useParams();

	const [errors, setErrors] = useState({
		issueDescription: '',
		issueStatus: '',
        employeeId: ''
	})

	const navigator = useNavigate();

	useEffect(() => {
		// commented out since getIssue does not exist yet

		//if(issueId) {
		//	getIssue(issueId).then((response) => {
		//		setIssueDescription(response.data.issueDescription);
		//		setIssueStatus(response.data.issueStatus);
        //      setEmployeeId(response.data.employeeId);
		//	}).catch(error => {
		//		console.error(error);
		//	})
		//}
	}, [issueId])

	function saveOrUpdateIssue(e) {
		e.preventDefault();

		if (validateForm()) {

			const issue = {issueId, issueDescription, issueStatus, projectId, employeeId}
			console.log(issue)

			if (issueId) {
				// update issue

				// commented out since updateIssue does not exist yet
				// not sure about parameters hence the (?)

				//updateIssue( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/projects/${projectId}/issues`);
				//}).catch(error => {
				//	console.error(error);
				//})
			} else {
				// add issue

				// commented out since createIssue does not exist yet
				// not sure about parameters hence the (?)

				//createIssue( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/projects/${projectId}/issues`);
				//}).catch(errors => {
				//	console.error(errors);
				//})
			}
		}
	}

	function validateForm() {
		let valid = true;
		const errorsCopy = {... errors}

		if (issueDescription.trim()) {
			errorsCopy.issueDescription = '';
		} else {
			errorsCopy.issueDescription = 'Issue Description is required';
			valid = false;
		}

		if (issueStatus.trim()) {
			errorsCopy.issueStatus = '';
		} else {
			errorsCopy.issueStatus = 'Issue Status is required';
			valid = false;
		}

        if (employeeId.trim()) {
			errorsCopy.employeeId = '';
		} else {
			errorsCopy.employeeId = 'Employee ID is required';
			valid = false;
		}

		setErrors(errorsCopy);
		return valid;
	}

	function pageTitle() {
		if (issueId) {
			return <h2>Update Issue</h2>
		} else {
			return <h2>Add Issue</h2>
		}
	}

	function back(e) {
		e.preventDefault();
		navigator(`/documentcontrol/projects/${projectId}/issues`);
	}

	return (
		<div className="container">
			<br/><br/><br/>
			<div className="row">
				<div className="card col-md-6 offset-md-3 offset-md-3">
					{pageTitle()}
					<div className="card-body">
						<form>
							<div className="form-group mb-3">
								<label className="form-label">Issue Description</label>
								<input
									type="text"
									placeholder="Issue Description"
									name="issueDescription"
									value={issueDescription}
									className={`form-control ${errors.issueDescription ? 'is-invalid' : ''}`}
									onChange={(e) => setIssueDescription(e.target.value)}
								>
								</input>
								
								{errors.issueDescription && <div className="invalid-feedback">{errors.issueDescription}</div>}
							</div>
							<div className="form-group mb-3">
								<label className="form-label">Issue Status</label>
								<input
									type="text"
									placeholder="Issue Status"
									name="issueStatus"
									value={issueStatus}
									className={`form-control ${errors.issueStatus ? 'is-invalid' : ''}`}
									onChange={(e) => setIssueStatus(e.target.value)}
								>
								</input>
								
								{errors.issueStatus && <div className="invalid-feedback">{errors.issueStatus}</div>}
							</div>
                            <div className="form-group mb-3">
								<label className="form-label">Reporter Employee ID</label>
								<input
									type="text"
									placeholder="Employee ID"
									name="employeeID"       // is this supposed to be "Id" or "ID"?
									value={employeeId}
									className={`form-control ${errors.employeeId ? 'is-invalid' : ''}`}
									onChange={(e) => setEmployeeId(e.target.value)}
								>
								</input>
								
								{errors.employeeId && <div className="invalid-feedback">{errors.employeeId}</div>}
							</div>
							<button className="btn btn-dark mb-2" onClick={saveOrUpdateIssue}>Submit</button>
							<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCIssue