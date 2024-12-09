import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCListPlan = () => {

	const [plans, setPlans] = useState([]);
    const {id : regionId, chopcode : chopCode, mileage} = useParams();
    const [locationName, setLocationName] = useState('');

	const navigator = useNavigate();

	useEffect(() => {
		if (mileage) {
			// Insert Fetch plans


			// Insert Fetch location name


			// test data to be deleted after
            const dummyPlans = [
                { chopCode: 'BELL', mileage: '0.25', drawingNumber: 'BELL000.25FG_SW_1', uploadDate: '2023-10-13', assignedStatus: 'FALSE', archiveStatus: 'In Service' },
                { chopCode: 'BELL', mileage: '0.25', drawingNumber: 'BELL001.43FA_JP_1', uploadDate: '2020-04-08', assignedStatus: 'FALSE', archiveStatus: 'Historical' },
                { chopCode: 'BELL', mileage: '0.25', drawingNumber: 'BELL001.43FE_SL_1', uploadDate: '2021-10-24', assignedStatus: 'FALSE', archiveStatus: 'In Service' },
              ];
            const dummyLocationName = "Dummy Location";

            setPlans(dummyPlans);
            setLocationName(dummyLocationName);
		}
	}, [mileage]);

	function back() {
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations`);
	}

	function addNewPlan() {
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans/add`);
	}

	function updatePlan(drawingNumber) {
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans/update/${drawingNumber}`);
	}

	function removePlan(drawingNumber) {
		console.log(drawingNumber);

		// remove plan logic here
	}

    // NOTE: the keys might need to be modified since only one is listed here but there are multiple
	return (
		<div className='container'><br />
			<h2>{locationName} Plans</h2>
			<button className="btn btn-dark mb-2" onClick={addNewPlan}>Add Plan</button>
			<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
                        <th>Chop Code</th>
                        <th>Mileage</th>
                        <th>Drawing Number</th>
                        <th>Upload Date</th>
                        <th>Assigned Status</th>
                        <th>Archive Status</th>
                        <th>Actions</th>
					</tr>
				</thead>
				<tbody>
					{
						plans.map(plan =>
							<tr key={plan.drawingNumber}>
								<td>{plan.chopCode}</td>
                                <td>{plan.mileage}</td>
                                <td>{plan.drawingNumber}</td>
                                <td>{plan.uploadDate}</td>
                                <td>{plan.assignedStatus}</td>
                                <td>{plan.archiveStatus}</td>
								<td>
									<button className="btn btn-dark" onClick={() => updatePlan(plan.drawingNumber)}>Update</button>
									<button
										className="btn btn-dark"
										onClick={() => {
											if (window.confirm("Are you sure you want to delete plan " + plan.drawingNumber + "?")) {
												removePlan(plan.drawingNumber);
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
}
export default DCListPlan