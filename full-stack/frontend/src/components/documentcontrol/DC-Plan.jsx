import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
import {
	createArchivePlan,
	createPlan,
	getArchivePlan,
	getPlan,
	updateArchivePlan,
	updatePlan
} from "../../services/RegionService.js";

const DCPlan = () => {
	const [planDrawingNumber, setPlanDrawingNumber] = useState('')
	const [planUploadDate, setPlanUploadDate] = useState('')
    const [planAssignedStatus, setPlanAssignedStatus] = useState('')
    const [planArchiveStatus, setPlanArchiveStatus] = useState('')
	const {id : regionId, chopcode : chopCode, mileage, drawingnumber : drawingNumber} = useParams();

	const [errors, setErrors] = useState({
		planDrawingNumber: '',
		planUploadDate: '',
        planAssignedStatus: '',
        planArchiveStatus: '',
	})

	const navigator = useNavigate();

	useEffect(() => {
		if (drawingNumber) {
			getArchivePlan(regionId, chopCode, mileage, drawingNumber).then((response) => {
				setPlanDrawingNumber(response.data.drawingNumber);
				setPlanUploadDate(response.data.uploadDate);
				setPlanAssignedStatus(response.data.assignedStatus);
				setPlanArchiveStatus(response.data.archiveStatus);
			}).catch(error => {
				console.error("Error fetching archive plan:", error.response?.data || error.message);
			});
		}
	}, [drawingNumber])

	async function saveOrUpdatePlan(e) {
		e.preventDefault();

		if (validateForm()) {
			const plan = {
				drawingNumber: planDrawingNumber,
			};

			const archivePlan = {
				uploadDate: planUploadDate,
				assignedStatus: planAssignedStatus,
				archiveStatus: planArchiveStatus,
			};

			try {
				if (drawingNumber) {
					// Update Plan and ArchivePlan sequentially
					await updatePlan(regionId, chopCode, mileage, drawingNumber, plan);
					await updateArchivePlan(regionId, chopCode, mileage, drawingNumber, archivePlan);
					console.log("Update successful");
				} else {
					// Create Plan first
					const response = await createPlan(regionId, chopCode, mileage, plan);
					const newDrawingNumber = response.data.drawingNumber; // Assuming backend returns drawingNumber

					// Then create ArchivePlan
					await createArchivePlan(regionId, chopCode, mileage, newDrawingNumber, archivePlan);
					console.log("Create successful");
				}

				navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans`);
			} catch (error) {
				console.error("Error handling create or update:", error.response?.data || error.message);
			}
		}
	}

	function validateForm() {
		let valid = true;
		const errorsCopy = { ...errors };

		if (planDrawingNumber.trim()) {
			errorsCopy.planDrawingNumber = '';
		} else {
			errorsCopy.planDrawingNumber = 'Drawing Number is required';
			valid = false;
		}

		if (planUploadDate.trim()) {
			// Optionally validate if the string is in "YYYY-MM-DD" format
			const isValidDate = !isNaN(Date.parse(planUploadDate));
			if (isValidDate) {
				console.log("Valid date:", planUploadDate);
			} else {
				console.error("Invalid date format:", planUploadDate);
				errorsCopy.planUploadDate = "Invalid date format.";
				valid = false;
			}
		} else {
			errorsCopy.planUploadDate = "Upload Date is required.";
			valid = false;
		}

		if (planAssignedStatus !== '') {
			errorsCopy.planAssignedStatus = '';
		} else {
			errorsCopy.planAssignedStatus = 'Assigned Status is required';
			valid = false;
		}

		if (planArchiveStatus.trim()) {
			errorsCopy.planArchiveStatus = '';
		} else {
			errorsCopy.planArchiveStatus = 'Archive Status is required';
			valid = false;
		}

		setErrors(errorsCopy);
		return valid;
	}

	function pageTitle() {
		if (drawingNumber) {
			return <h2>Update Plan</h2>
		} else {
			return <h2>Add Plan</h2>
		}
	}

	function back(e) {
		e.preventDefault();
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans`);
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
								<label className="form-label">Drawing Number</label>
								<input
									type="text"
									placeholder="Drawing Number"
									name="drawingNumber"
									value={planDrawingNumber}
									className={`form-control ${errors.planDrawingNumber ? 'is-invalid' : ''}`}
									onChange={(e) => setPlanDrawingNumber(e.target.value)}
								>
								</input>

								{errors.planDrawingNumber && <div className="invalid-feedback">{errors.planDrawingNumber}</div>}
							</div>
							<div className="form-group mb-3">
								<label className="form-label">Upload Date</label>
								<input
									type="date"
									name="uploadDate"
									value={planUploadDate}
									className={`form-control ${errors.planUploadDate ? 'is-invalid' : ''}`}
									onChange={(e) => setPlanUploadDate(e.target.value)} // Ensure it's a string
								>
								</input>

								{errors.planUploadDate &&
									<div className="invalid-feedback">{errors.planUploadDate}</div>}
							</div>
							<div className="form-group mb-3">
								<label className="form-label">Assigned Status</label>
								<input
									type="text"
									placeholder="Assigned Status"
									name="assignedStatus"
									value={planAssignedStatus}
									className={`form-control ${errors.planAssignedStatus ? 'is-invalid' : ''}`}
									onChange={(e) => setPlanAssignedStatus(e.target.value)}
								>
								</input>

								{errors.planAssignedStatus && <div className="invalid-feedback">{errors.planAssignedStatus}</div>}
							</div>
                            <div className="form-group mb-3">
								<label className="form-label">Archive Status</label>
								<input
									type="text"
									placeholder="Archive Status"
									name="archiveStatus"
									value={planArchiveStatus}
									className={`form-control ${errors.planArchiveStatus ? 'is-invalid' : ''}`}
									onChange={(e) => setPlanArchiveStatus(e.target.value)}
								>
								</input>

								{errors.planArchiveStatus && <div className="invalid-feedback">{errors.planArchiveStatus}</div>}
							</div>
							<button className="btn btn-dark mb-2" onClick={saveOrUpdatePlan}>Submit</button>
							<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCPlan