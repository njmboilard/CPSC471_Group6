import React, {useEffect, useState} from 'react'
import {useParams} from "react-router-dom";
import {getRegion, listSubdivisions} from "../../services/RegionService.js";

const RdListSubdivision = () => {
	const [subdivisions, setsubdivisions] = useState([]);
	const {id: regionId} = useParams();
	const [regionName, setRegionName] = useState('');

	useEffect(() => {
		if (regionId) {
			// Fetch subdivisions
			listSubdivisions(regionId).then((response) => {
				setsubdivisions(response.data);
			}).catch(error => {
				console.error(error);
			});

			// Fetch region name
			getRegion(regionId).then((response) => {
				setRegionName(response.data.name);
			}).catch(error => {
				console.error(error);
			});
		}
	}, [regionId]);

	return (
		<div className='container'><br />
			<h2>{regionName} Subdivisions</h2>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
						<th>Chop Code</th>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
					{
						subdivisions.map(subdivision =>
							<tr key={subdivision.chopCode}>
								<td>{subdivision.chopCode}</td>
								<td>{subdivision.name}</td>
							</tr>
						)
					}
				</tbody>
			</table>
		</div>
	)
}
export default RdListSubdivision
