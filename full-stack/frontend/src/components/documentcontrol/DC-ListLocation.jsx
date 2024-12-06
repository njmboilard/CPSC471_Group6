import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCListLocation = () => {

	const [locations, setLocations] = useState([]);
	const {id : regionId, chopcode : chopCode} = useParams();
	const [subdivisionName, setSubdivisionName] = useState('');

	const navigator = useNavigate();

	useEffect(() => {
		if (chopCode) {
			// Insert Fetch locations


			// Insert Fetch subdivision name


			// test data to be deleted after
			const dummyLocations = [
				{ chopCode: "BELL", mileage: '0.25', type: 'Signals - Controlled', name: 'Smiths Falls Centre' },
				{ chopCode: "BELL", mileage: '1.43', type: 'Grade Crossing Warning System', name: 'Carroll Road' },
				{ chopCode: "BELL", mileage: '2.00', type: 'Signals - Automatic', name: 'Glenview Road' },
			  ];
			const dummySubdivisionName = "Dummy Subdivision";

			setLocations(dummyLocations);
			setSubdivisionName(dummySubdivisionName);
		}
	}, [chopCode]);

	function back() {
		navigator(`/documentcontrol/regions/${regionId}/subdivisions`);
	}

	function addNewLocation() {
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations/add`);
	}

	function updateLocation(mileage) {
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations/update/${mileage}`);
	}

	function removeLocation(mileage) {
		console.log(mileage);

		// remove location logic here
	}

	function plan(mileage) {
		console.log(mileage);
		navigator(`/documentcontrol/regions/${regionId}/subdivisions/${chopCode}/locations/${mileage}/plans`);
	}

    // NOTE: the keys might need to be modified since only one is listed here but there are multiple
	return (
		<div className='container'><br />
			<h2>{subdivisionName} Locations</h2>
			<button className="btn btn-dark mb-2" onClick={addNewLocation}>Add Location</button>
			<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
                        <th>Chop Code</th>
						<th>Mileage</th>
						<th>Location Type</th>
						<th>Location Name</th>
                        <th>Actions</th>
					</tr>
				</thead>
				<tbody>
					{
						locations.map(location =>
							<tr key={location.mileage}>
								<td>{location.chopCode}</td>
								<td>{location.mileage}</td>
								<td>{location.type}</td>
                                <td>{location.name}</td>
								<td>
									<button className="btn btn-dark" onClick={() => updateLocation(location.mileage)}>Update</button>
									<button
										className="btn btn-dark"
										onClick={() => {
											if (window.confirm("Are you sure you want to delete location " + location.name + "?")) {
												removeLocation(location.mileage);
											}
										}}
										style={{marginLeft: '10px'}}
									>
										Delete
									</button>
									<button className="btn btn-dark" onClick={() => plan(location.mileage)} style={{marginLeft: '10px'}}>Plans</button>
								</td>
							</tr>
						)
					}
				</tbody>
			</table>
		</div>
	)
}
export default DCListLocation