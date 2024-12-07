import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCFieldStaff = () => {

    const {id : projectId, fsid : fieldStaffId} = useParams();

    const [fsEmployeeName, setFSEmployeeName] = useState('')
	const [fsEmployeeDepartment, setFSEmployeeDepartment] = useState('')
    const [fsEmployeePosition, setFSEmployeePosition] = useState('')

	const [errors, setErrors] = useState({
	    fsEmployeeName: '',
		fsEmployeeDepartment: '',
        fsEmployeePosition: ''
	})

	const navigator = useNavigate();

	useEffect(() => {
		// commented out since getFieldStaff does not exist yet

		//if(fieldStaffId) {
		//	getFieldStaff(fieldStaffId).then((response) => {
        //      setFSEmployeeName(response.data.fsEmployeeName);
		//		setFSEmployeeDepartment(response.data.fsEmployeeDepartment);
        //      setFSEmployeePosition(response.data.fsEmployeePosition);
		//	}).catch(error => {
		//		console.error(error);
		//	})
		//}
	}, [fieldStaffId])

	function saveOrUpdateFieldStaff(e) {
		e.preventDefault();

		if (validateForm()) {
            
            const fieldStaff = {fieldStaffId, fsEmployeeName, fsEmployeeDepartment, fsEmployeePosition}

			console.log(issue)

			if (fieldStaffId) {
				// update field staff

				// commented out since updateFieldStaff does not exist yet
				// not sure about parameters hence the (?)

				//updateFieldStaff( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/projects/${projectId}/personnel`);
				//}).catch(error => {
				//	console.error(error);
				//})
			} else {
				// add field staff

				// commented out since createFieldStaff does not exist yet
				// not sure about parameters hence the (?)

				//createFieldStaff( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/projects/${projectId}/personnel`);
				//}).catch(errors => {
				//	console.error(errors);
				//})
			}
		}
	}

	function validateForm() {
		let valid = true;
		const errorsCopy = {... errors}

		if (fsEmployeeName.trim()) {
			errorsCopy.fsEmployeeName = '';
		} else {
			errorsCopy.fsEmployeeName = 'Employee Name is required';
			valid = false;
		}

		if (fsEmployeeDepartment.trim()) {
			errorsCopy.fsEmployeeDepartment = '';
		} else {
			errorsCopy.fsEmployeeDepartment = 'Employee Department is required';
			valid = false;
		}

        if (fsEmployeePosition.trim()) {
			errorsCopy.fsEmployeePosition = '';
		} else {
			errorsCopy.fsEmployeePosition = 'Employee Position is required';
			valid = false;
		}

		setErrors(errorsCopy);
		return valid;
	}

	function pageTitle() {
		if (fieldStaffId) {
			return <h2>Update Field Staff</h2>
		} else {
			return <h2>Add Field Staff</h2>
		}
	}

	function back(e) {
		e.preventDefault();
		navigator(`/documentcontrol/projects/${projectId}/personnel`);
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
								<label className="form-label">Field Staff Employee Name</label>
								<input
									type="text"
									placeholder="Employee Name"
									name="employeeName"
									value={fsEmployeeName}
									className={`form-control ${errors.fsEmployeeName ? 'is-invalid' : ''}`}
									onChange={(e) => setFSEmployeeName(e.target.value)}
								>
								</input>
								
								{errors.fsEmployeeName && <div className="invalid-feedback">{errors.fsEmployeeName}</div>}
							</div>
							<div className="form-group mb-3">
								<label className="form-label">Field Staff Employee Department</label>
								<input
									type="text"
									placeholder="Employee Department"
									name="department"
									value={fsEmployeeDepartment}
									className={`form-control ${errors.fsEmployeeDepartment ? 'is-invalid' : ''}`}
									onChange={(e) => setFSEmployeeDepartment(e.target.value)}
								>
								</input>
								
								{errors.fsEmployeeDepartment && <div className="invalid-feedback">{errors.fsEmployeeDepartment}</div>}
							</div>
                            <div className="form-group mb-3">
								<label className="form-label">Field Staff Employee Position</label>
								<input
									type="text"
									placeholder="Employee Position"
									name="position"
									value={fsEmployeePosition}
									className={`form-control ${errors.fsEmployeePosition ? 'is-invalid' : ''}`}
									onChange={(e) => setFSEmployeePosition(e.target.value)}
								>
								</input>
								
								{errors.fsEmployeePosition && <div className="invalid-feedback">{errors.fsEmployeePosition}</div>}
							</div>
							<button className="btn btn-dark mb-2" onClick={saveOrUpdateFieldStaff}>Submit</button>
							<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCFieldStaff