import React, {useEffect, useState} from 'react'
import {useParams} from "react-router-dom";
import {listSubdivisions} from "../../services/RegionService.js";

const RdListSubdivision = () => {
	const [subdivisions, setsubdivisions] = useState([]);
	const {id: regionId} = useParams();

	useEffect(() => {
		if (regionId) {
			listSubdivisions(regionId).then((response) => {
				setsubdivisions(response.data);
			}).catch(error => {
				console.error(error);
			})
		}
	}, [regionId]);

	return (
		<div className='container'><br />
			<h2>Subdivisions for Region {regionId}</h2>
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
